package com.company.smdms.security;

import com.company.smdms.entity.Document;
import com.company.smdms.entity.User;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;
import io.jmix.webdav.entity.WebdavCookieAuthToken;
import io.jmix.webdav.entity.WebdavCredentials;
import io.jmix.webdav.entity.WebdavDocument;
import io.jmix.webdav.entity.WebdavDocumentVersion;
import io.jmix.webdav.entity.WebdavLink;
import io.jmix.webdav.entity.WebdavLockDescriptor;

@ResourceRole(name = "WebdavUser", code = WebdavUserRole.CODE)
public interface WebdavUserRole {
    String CODE = "webdav-user";

    @MenuPolicy(menuIds = {"webdav_WebdavDocument.list", "Document.list", "User.list"})
    @ViewPolicy(viewIds = {"webdav_WebdavDocument.list", "Document.list", "Document.detail", "User.list"})
    void screens();

    @EntityAttributePolicy(entityClass = WebdavDocument.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = WebdavDocument.class, actions = EntityPolicyAction.ALL)
    void webdavDocument();

    @EntityAttributePolicy(entityClass = WebdavDocumentVersion.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = WebdavDocumentVersion.class, actions = EntityPolicyAction.ALL)
    void webdavDocumentVersion();

    @EntityAttributePolicy(entityClass = WebdavLink.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = WebdavLink.class, actions = EntityPolicyAction.ALL)
    void webdavLink();

    @EntityAttributePolicy(entityClass = WebdavLockDescriptor.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = WebdavLockDescriptor.class, actions = EntityPolicyAction.ALL)
    void webdavLockDescriptor();

    @EntityAttributePolicy(entityClass = WebdavCredentials.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = WebdavCredentials.class, actions = EntityPolicyAction.ALL)
    void webdavCredentials();

    @EntityAttributePolicy(entityClass = WebdavCookieAuthToken.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = WebdavCookieAuthToken.class, actions = EntityPolicyAction.ALL)
    void webdavCookieAuthToken();

    @EntityAttributePolicy(entityClass = Document.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Document.class, actions = EntityPolicyAction.ALL)
    void document();

    @EntityAttributePolicy(entityClass = User.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.ALL)
    void user();
}