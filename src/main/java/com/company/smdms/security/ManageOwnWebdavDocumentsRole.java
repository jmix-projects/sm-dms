package com.company.smdms.security;

import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import io.jmix.webdav.entity.WebdavDocument;

@RowLevelRole(name = "ManageOwnWebdavDocuments", code = ManageOwnWebdavDocumentsRole.CODE)
public interface ManageOwnWebdavDocumentsRole {
    String CODE = "manage-own-webdav-documents";

    @JpqlRowLevelPolicy(entityClass = WebdavDocument.class, where = "{E}.createdBy = :current_user_username")
    void webdavDocument();
}