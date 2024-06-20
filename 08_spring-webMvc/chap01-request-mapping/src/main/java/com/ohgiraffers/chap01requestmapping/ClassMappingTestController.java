package com.ohgiraffers.chap01requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;

@Controller
@RequestMapping("/orders")
public class ClassMappingTestController {

    // class 레벨 매핑
    @GetMapping("/regist")
    public String registOrder(Model model){
        model.addAttribute("message", "get 방식의 주문 등록용 핸들러 메소드를 호출함");
        return "mappingResult";
    }

    @PostMapping("/regist")
    public String registOrderPost(Model model){
        model.addAttribute("message", "post 방식의 주문 등록용 핸들러 메소드를 호출함");
        return "mappingResult";
    }

    @PostMapping("/postMapping")
    public String registOrderPost( @RequestParam("orderName") String orderName,
                                   @RequestParam("orderQuantity") int orderQuantity,Model model) {

//        // 여기에 데이터를 저장하는 로직을 추가합니다.
//        // 예: 데이터베이스에 저장
//        System.out.println("Order Name: " + orderName);
//        System.out.println("Order Quantity: " + orderQuantity);

        // 데이터를 저장한 후 사용자에게 메시지를 전달합니다.
        model.addAttribute("message", "post 방식의 주문 등록용 핸들러 메소드를 호출함");
        model.addAttribute("orderName", orderName);
        model.addAttribute("orderQuantity", orderQuantity);

        return "mappingResult";
    }

    // 여러 개의 패턴 매핑
    // value 속성에 중괄호를 이용해 매핑할 url을 나열한다.
    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)
    public String modifyAndDelete(Model model){
        model.addAttribute("message", "post 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 메소드 호출함");
        return "mappingResult";
    }


}
