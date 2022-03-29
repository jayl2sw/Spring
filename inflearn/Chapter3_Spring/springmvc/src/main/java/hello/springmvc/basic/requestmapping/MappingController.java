package hello.springmvc.basic.requestmapping;

import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value="/mapping-get-v1", method= RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mapping-get-v1");
        return "ok";
    }

    @GetMapping(value="/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mapping-get-v2");
        return "ok";
    }

    // PathVariable 사용 (변수명이 같으면 생략가능) => @PathVariable userId
    // Django에서의 variable routing
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
//  public String mappingPath(@PathVariable userId) {
//      log.info("mappingPath userId={}", userId);
        log.info("mappingPath userId={}", data);
        return "ok";
    }

    @GetMapping("mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    // 특정 파라미터가 있을 때만 매핑이 된다.
    @GetMapping(value = "/mapping-param", params="mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }

    // 특정 헤더로 추가 매핑
    @GetMapping(value = "/mapping-header", headers="mode=debug")
    public String mappingHeaders(){
        log.info("mappingHeader");
        return "ok";
    }

//    미디어 타입 조건 매핑
//    consume = 소비하는 입장 (정보를 소비), produce = Controller가 생산해내는 미디어타입
    @PostMapping(value="/mapping-consume", consumes="application/json")
    public String mappingConsume(){
        log.info("mappingConsume");
        return "ok";
    }

    @PostMapping(value="mapping-produce", produces="text/html")
    public String mappingProduce(){
        log.info("mappingProduce");
        return "ok";
    }
}
