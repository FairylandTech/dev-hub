/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 22:01:24 UTC+08:00
 ****************************************************/
package host.fairy.dto.converter;

import host.fairy.dto.response.DepartmentResponseDTO;
import host.fairy.entity.DepartmentEntity;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 部门实体类转部门Response DTO
 *
 * @author Lionel Johnson
 */
public class DepartmentConverter {
    public static DepartmentResponseDTO toDTO(DepartmentEntity entity) {
        DepartmentResponseDTO dto = new DepartmentResponseDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
    
    public static List<DepartmentResponseDTO> toDTOList(List<DepartmentEntity> entities) {
        return entities.stream()
                .map(DepartmentConverter::toDTO)
                .collect(Collectors.toList());
    }
}
