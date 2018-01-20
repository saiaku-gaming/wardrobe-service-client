package com.valhallagame.wardrobeserviceclient.message;

import javax.validation.constraints.NotNull;

import com.valhallagame.common.validation.CheckLowercase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DebugAddWardrobeItemParameter {
	@NotNull
	@CheckLowercase
	private String username;

	@NotNull
	private String itemName;
}
