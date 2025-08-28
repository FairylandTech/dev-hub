/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 13:47:50 UTC+08:00
 ****************************************************/
package host.fairy.result;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果封装
 * 包含总记录数和当前页数据列表
 *
 * @author Lionel Johnson
 */
@Data
@AllArgsConstructor
public class ListRocordResult<T> implements Serializable {
    
    private Long total;
    private List<T> rocords;
}
