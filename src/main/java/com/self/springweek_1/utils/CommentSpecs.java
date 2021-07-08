package com.self.springweek_1.utils;

import com.self.springweek_1.model.Comment;
import org.springframework.data.jpa.domain.Specification;

public class CommentSpecs {

    public static Specification<Comment> withArticle_id(Long article_id) {
        return ((root, query, builder) ->
                builder.equal(root.get("article_id"), article_id)
        );
    }
}
