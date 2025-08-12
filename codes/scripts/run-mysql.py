# coding: utf-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2024-06-21 23:48:48 UTC+08:00
"""

from pathlib import Path
import typer
from getpass import getuser
from sh import docker, chown, id


def create_directory(directory: str):
    path = Path(directory)

    if not path.exists():
        path.mkdir(parents=True)

    return path


def execute_command(user, group, data_path, container_name, mysql_password):
    command = [
        "run",
        "-d",
        "--name", container_name,
        "--network", "DockerCustomNet",
        "--ip", "173.1.10.1",
        "--user", f"{user}:{group}",
        "--privileged=true",
        "-e", "TZ=Asia/Shanghai",
        "-e", f"MYSQL_ROOT_PASSWORD='{mysql_password}'",
        "-p", "51001:3306",
        "-v", f"{data_path}:/var/lib/mysql",
        "--restart", "always",
        "mysql:8.0.35",
    ]

    docker(command)
    docker("logs", "-f", container_name)


def main(container_name: str = typer.Option(..., help="The name of the docker container"),
         volume_dir: str = typer.Option("/data/container/volume", help="Folder for Docker volumes data"),
         mysql_password: str = typer.Option(..., help="MySQL root password"),
         ):
    USER = id("-u")
    GROUP = id("-g")

    if USER != 0:
        typer.echo("The script must be run as root or with sudo.")
        raise typer.Exit()

    data_path = create_directory(f"{volume_dir}/{container_name}/data")
    chown("-R", f"{USER}:{GROUP}", data_path)

    execute_command(USER, GROUP, data_path, container_name, mysql_password)


if __name__ == "__main__":
    typer.run(main)
