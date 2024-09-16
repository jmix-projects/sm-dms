package com.company.smdms.security;

import com.company.smdms.entity.Document;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.security.model.RowLevelBiPredicate;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.role.annotation.PredicateRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import org.springframework.context.ApplicationContext;

@RowLevelRole(name = "ReadSharedDocumentRole", code = ReadSharedDocumentRole.CODE)
public interface ReadSharedDocumentRole {
    String CODE = "read-shared-document-role";

    @PredicateRowLevelPolicy(
            entityClass = Document.class,
            actions = {RowLevelPolicyAction.READ})
    default RowLevelBiPredicate<Document, ApplicationContext> documentReaders() {
        return (document, applicationContext) -> {
            CurrentAuthentication currentAuthentication = applicationContext.getBean(CurrentAuthentication.class);
            return document.getCreatedBy().equals(currentAuthentication.getUser().getUsername()) || (document.getReaders() != null
                    && document.getReaders().stream().anyMatch((u) -> u.getUsername().equals(currentAuthentication.getUser().getUsername())));
        };
    }
}