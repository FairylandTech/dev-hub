/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-27 21:58:35 UTC+08:00
 ****************************************************/
package host.fairy.controller;

import host.fairy.common.ResponseBodyResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Lionel Johnson
 */
@RestController
public class TestController {
    
    @GetMapping("/test")
    public ResponseBodyResult<HashMap<String, Object>> test() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Lionel Johnson");
        map.put("age", 25);
        return ResponseBodyResult.success(map);
    }
}
