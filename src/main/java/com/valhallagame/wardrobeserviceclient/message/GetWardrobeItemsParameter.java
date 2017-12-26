package com.valhallagame.wardrobeserviceclient.message;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetWardrobeItemsParameter {
	@NotNull
	private String characterName;
}
