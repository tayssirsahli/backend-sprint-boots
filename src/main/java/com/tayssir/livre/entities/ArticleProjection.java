package com.tayssir.livre.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomlivre", types = { Livre.class })
public interface ArticleProjection {

    public String getNomArticle();

}
