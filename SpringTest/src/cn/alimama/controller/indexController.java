package cn.alimama.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/index")
public class indexController {
    Logger logger = Logger.getLogger(indexController.class);
    @RequestMapping("/index.html")
    public String index(){
        return "index";
        // http://127.0.0.1:8080/SpringMvc_day2_1/WEB-INF/jsp/index.jsp
    }
    /**
     * 参数传递方式1  controller====>view
     * 核心对象ModelAndView对象
     * */
    @RequestMapping(value = "/loginUser1.html",method = RequestMethod.POST)
    public ModelAndView index1(String userName, String userPwd){
        ModelAndView modelAndView = new ModelAndView();
        final String USERNAME = "niuwei";
        final String USERPWD = "niuwei666";
        logger.info("接收到的userName=====>"+userName+"\n接收到的userPwd=====>"+userPwd);
        if(userName.equals(USERNAME)&&userPwd.equals(USERPWD)){
            //1--封装用户名
            modelAndView.addObject("uname",userName);
            //2--编辑视图名
            modelAndView.setViewName("welcome");
            // http://127.0.0.1:8080/SpringMvc_day2_1/WEB-INF/jsp/welcome.jsp
        }else{
            //1--编辑视图名
            modelAndView.setViewName("error");
            // http://127.0.0.1:8080/SpringMvc_day2_1/WEB-INF/jsp/error.jsp
        }
        return modelAndView;
    }
    /**
     * 参数传递方式2  controller====>view
     * 核心对象Model对象
     * */
    @RequestMapping(value = "/loginUser2.html",method = RequestMethod.POST)
    public String index2(String userName, String userPwd, Model model){
        ModelAndView modelAndView = new ModelAndView();
        final String USERNAME = "niuwei";
        final String USERPWD = "niuwei666";
        logger.info("接收到的userName=====>"+userName+"\n接收到的userPwd=====>"+userPwd);
        if(userName.equals(USERNAME)&&userPwd.equals(USERPWD)){
            //1--封装用户名
            model.addAttribute("uname",userName);
            return "welcome";
            // http://127.0.0.1:8080/SpringMvc_day2_1/WEB-INF/jsp/welcome.jsp
        }else{
            //1--编辑视图名
            return "error";
            // http://127.0.0.1:8080/SpringMvc_day2_1/WEB-INF/jsp/error.jsp
        }
    }
    /**
     * 参数传递方式3  controller====>view
     * 核心对象Map对象
     * */
    @RequestMapping(value = "/loginUser3.html",method = RequestMethod.POST)
    public String index3(String userName, String userPwd, Map<String,Object> map){
        ModelAndView modelAndView = new ModelAndView();
        final String USERNAME = "niuwei";
        final String USERPWD = "niuwei666";
        logger.info("接收到的userName=====>"+userName+"\n接收到的userPwd=====>"+userPwd);
        if(userName.equals(USERNAME)&&userPwd.equals(USERPWD)){
            //1--封装用户名
            map.put("uname",userName);
            return "welcome";
            // http://127.0.0.1:8080/SpringMvc_day2_1/WEB-INF/jsp/welcome.jsp
        }else{
            //1--编辑视图名
            return "error";
            // http://127.0.0.1:8080/SpringMvc_day2_1/WEB-INF/jsp/error.jsp
        }
    }

    @RequestMapping(value = "/loginUser4.html",method = RequestMethod.POST)
    @ResponseBody
    public String index3(String userName, String userPwd){
        boolean flag = false;
        final String USERNAME = "niuwei";
        final String USERPWD = "niuwei666";
        logger.info("接收到的userName=====>"+userName+"\n接收到的userPwd=====>"+userPwd);
        if(userName.equals(USERNAME)&&userPwd.equals(USERPWD)){
            flag = true;
        }
            return flag+"";
    }



    @RequestMapping("/createUser.html")
    public String createUser(){
        return "createUser";
    }

    @RequestMapping(value = "/docreateUser.html",method = RequestMethod.POST)
    @ResponseBody
    public String docreateUser(@RequestParam String uName){
        logger.info("uName====>"+uName);
        boolean flag = false;
        final String USERNAME = "admin";
        if(uName.equals(USERNAME)){
            flag = true;
        }
        return flag+"";
    }
}
