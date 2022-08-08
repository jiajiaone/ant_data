package com.model.ant_data.api.okex.consts;

public class RequestArgs {

	// 产品频道 - 币种
	public static String instruments =
			"{ \n" + "  \"op\": \"subscribe\",  \n" + "  \"args\":   [    \n" + "    {     \n" + "      \"channel\" : \"instruments\",\n" + "      \"instType\": \"SPOT\"\n"
					+ "    }\n" + "  ] \n" + "}";
}
