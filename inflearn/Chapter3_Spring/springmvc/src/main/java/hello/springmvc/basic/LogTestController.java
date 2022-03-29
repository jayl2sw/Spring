package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // Controller 일때는 view name을 반환 RestController일 땐, html바디에다가 넣는다.
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

//        System.out.println("name="+ name);

        log.trace("trace log={}", name);
        log.debug("debug log={}", name); // 개발 서버
        log.info("info log={}", name);  // 운영 서버
//        log.info("info log="+ name);  // 이렇게 해도 되지만 이렇게 하면 연산이 일어난다 => 사용하지 않아도 리소스 사용
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";

    }
}
