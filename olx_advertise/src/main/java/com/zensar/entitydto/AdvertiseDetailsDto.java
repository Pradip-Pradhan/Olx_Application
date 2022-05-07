package com.zensar.entitydto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertiseDetailsDto {

	private int id;
	private String title;
	private int price;
	private String category="Electronic goods";
	private String description;
	private String userName="anand";
	private String createdDate="xxx";
	private String modifiedDate="xxx";
	private String status="OPEN";
}
