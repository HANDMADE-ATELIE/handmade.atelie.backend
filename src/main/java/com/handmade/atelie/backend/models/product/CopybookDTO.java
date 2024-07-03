package com.handmade.atelie.backend.models.product;

import java.util.List;

public record CopybookDTO(String name, String description, String imageUrl, double price, List<CopyBookEspecificationDTO> especifications) {

}
