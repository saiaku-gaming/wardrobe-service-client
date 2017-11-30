package com.valhallagame.wardrobeserviceclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetWardrobeItemsParameter {
	private String characterName;
}
