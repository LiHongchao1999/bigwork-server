package com.study.bigwork.util;




import io.rong.RongCloud;
import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;
import io.rong.methods.user.User;

public class GetInfo {
	
	
	//获取用户token
		public TokenResult getToken(String type) {
			String appKey = "cpj2xarlcm6on";
			String appSecret = "NdGG1eNPWOnz1c";
			RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
			User user = rongCloud.user;
			long random = System.currentTimeMillis();
			String id = type +"_"+random;
			UserModel userModel = new UserModel().setId(id).setName(id).setPortrait(
					"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1678948314,1083480950&fm=26&gp=0.jpg");
			TokenResult results = null;
			try {
				results = user.register(userModel);
				System.out.println("getToken:  " + results.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return results;
		}
	
	

}
