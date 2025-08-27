package host.fairy;

import host.fairy.dto.request.EmployeeQueryRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    
    @Test
    void contextLoads() {
        EmployeeQueryRequestDTO build = EmployeeQueryRequestDTO.builder().name("张").gender(1).pageNum(1).pageSize(5).build();
        System.out.println("build.toString() = " + build.toString());
    }
    
}
