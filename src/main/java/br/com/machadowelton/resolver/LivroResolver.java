package br.com.machadowelton.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class LivroResolver implements GraphQLQueryResolver, GraphQLMutationResolver{

}
