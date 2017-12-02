package com.valhallagame.wardrobeserviceclient;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.wardrobeserviceclient.model.AddWardrobeItemParameter;
import com.valhallagame.wardrobeserviceclient.model.GetWardrobeItemsParameter;

public class WardrobeServiceClient {
	private static WardrobeServiceClient wardrobeServiceClient;

	private String wardrobeServiceServerUrl = "http://localhost:" + DefaultServicePortMappings.WARDROBE_SERVICE_PORT;
	private RestCaller restCaller;

	private WardrobeServiceClient() {
		restCaller = new RestCaller();
	}

	public static void init(String wardrobeServiceServerUrl) {
		WardrobeServiceClient client = get();
		client.wardrobeServiceServerUrl = wardrobeServiceServerUrl;
	}

	public static WardrobeServiceClient get() {
		if (wardrobeServiceClient == null) {
			wardrobeServiceClient = new WardrobeServiceClient();
		}

		return wardrobeServiceClient;
	}

	public RestResponse<List<String>> getWardrobeItems(String characterName) throws IOException {
		return restCaller.postCall(wardrobeServiceServerUrl + "/v1/wardrobe/get-wardrobe-items",
				new GetWardrobeItemsParameter(characterName), new TypeReference<List<String>>() {});
	}

	public RestResponse<String> addWardrobeItem(String characterName, String itemName) throws IOException {
		return restCaller.postCall(wardrobeServiceServerUrl + "/v1/wardrobe/add-wardrobe-item",
				new AddWardrobeItemParameter(characterName, itemName), String.class);
	}
}
