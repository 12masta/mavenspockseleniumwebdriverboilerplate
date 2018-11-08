package com.szkolqa.biolerplate.init

import com.szkolqa.biolerplate.BaseSpec
import io.qameta.allure.Epic
import io.qameta.allure.Feature

@Epic("InitSpec")
@Feature("InitSpec")
class InitSpec extends BaseSpec {
    def 'first specifiacation always pass'(){
        expect:
        driver.currentUrl == 'https://marcinstanek.pl/'
    }

    def 'first specifiacation always fail'(){
        expect:
        driver.currentUrl == 'failing tests'
    }
}
