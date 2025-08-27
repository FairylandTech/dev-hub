/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 09:40:07 UTC+08:00
 ****************************************************/
package host.fairy.dto.converter;

import host.fairy.dto.response.EmployeeResponseDTO;
import host.fairy.entity.EmployeeEntity;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lionel Johnson
 */
public class EmployeeConverter {
    public static EmployeeResponseDTO toDTO(EmployeeEntity entity) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        BeanUtils.copyProperties(entity, dto);
        
        // 处理 gender 字段转换
        if (entity.getGender() != null) {
            dto.setGender(entity.getGender() == 0 ? "女" : "男");
        } else {
            dto.setGender("未知");
        }
        
        // 处理 job 字段转换
        if (entity.getJob() != null) {
            String jobName = switch (entity.getJob()) {
                case 1 -> "班主任";
                case 2 -> "讲师";
                case 3 -> "学工主管";
                case 4 -> "教研主管";
                case 5 -> "咨询师";
                default -> "其他";
            };
            dto.setJob(jobName);
        } else {
            dto.setJob("未设置"); // 或者设置为 null 或空字符串
        }
        
        return dto;
    }
    
    public static List<EmployeeResponseDTO> toDTOList(List<EmployeeEntity> entities) {
        return entities.stream()
                .map(EmployeeConverter::toDTO)
                .collect(Collectors.toList());
    }
}
