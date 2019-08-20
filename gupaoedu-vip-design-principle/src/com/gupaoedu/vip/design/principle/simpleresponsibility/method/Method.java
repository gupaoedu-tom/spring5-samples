package com.gupaoedu.vip.design.principle.simpleresponsibility.method;

/**
 * Created by Tom
 */
public class Method {
    private void modifyUserInfo(String userName,String address){
        userName = "Tom";
        address = "Changsha";
    }

    private void modifyUserInfo(String userName,String... fileds){
        userName = "Tom";
//        address = "Changsha";
    }
    private void modifyUserInfo(String userName,String address,boolean bool){
        if(bool){

        }else{

        }

        userName = "Tom";
        address = "Changsha";
    }

    private void modifyUserName(String userName){
        userName = "Tom";
    }
    private void modifyAddress(String address){
        address = "Changsha";
    }




}
