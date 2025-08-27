/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 16:28:59 UTC+08:00
 ****************************************************/
package host.fairy.mapper;

import host.fairy.entity.FileEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Lionel Johnson
 */
@Mapper
public interface FileMapper {
    FileEntity selectById(Integer id);
    Integer insert(FileEntity entity);
}
