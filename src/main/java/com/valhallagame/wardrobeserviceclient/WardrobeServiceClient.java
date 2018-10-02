package com.valhallagame.wardrobeserviceclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.AbstractServiceClient;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestResponse;
import com.valhallagame.wardrobeserviceclient.message.AddWardrobeItemParameter;
import com.valhallagame.wardrobeserviceclient.message.GetWardrobeItemsParameter;

import java.io.IOException;
import java.util.List;

public class WardrobeServiceClient extends AbstractServiceClient {
	private static WardrobeServiceClient wardrobeServiceClient;

	private WardrobeServiceClient() {
		serviceServerUrl = "http://localhost:" + DefaultServicePortMappings.WARDROBE_SERVICE_PORT;
	}

	public static void init(String serviceServerUrl) {
		WardrobeServiceClient client = get();
		client.serviceServerUrl = serviceServerUrl;
	}

	public static WardrobeServiceClient get() {
		if (wardrobeServiceClient == null) {
			wardrobeServiceClient = new WardrobeServiceClient();
		}
		return wardrobeServiceClient;
	}

	public RestResponse<List<String>> getWardrobeItems(String username) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/wardrobe/get-wardrobe-items",
				new GetWardrobeItemsParameter(username), new TypeReference<List<String>>() {});
	}

	public RestResponse<String> addWardrobeItem(AddWardrobeItemParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/wardrobe/add-wardrobe-item",
				input, String.class);
	}
}
