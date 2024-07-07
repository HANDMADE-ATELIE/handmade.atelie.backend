package com.handmade.atelie.backend.models.product;

import java.util.List;

public record CopybookDTOWithID(String id, String name, String description, String imageUrl, double price, List<CopybookEspecificationDTOWithID> especifications) {
}
