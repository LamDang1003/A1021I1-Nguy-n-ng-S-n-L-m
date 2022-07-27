package controller;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
    @GetMapping("/edit")
    public ModelAndView setting(){
        return new ModelAndView("setting","res", ManagementAssertion.Setting.NOT_SET);
    }

    @PostMapping("/update")
    public String update(Setting setting){
        Setting s= Setting.getInstance();
        s.setLanguage(setting.getLanguage());
        s.setPageSize(setting.getPageSize());
        s.setSpamFilter(setting.isSpamFilter());
        s.setSingature(setting.getSingature());
        return "index";
    }
}