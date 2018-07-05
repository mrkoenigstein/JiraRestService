package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.AttachmentMeta;
import com.github.cschulc.jirarestservice.domain.Issuetype;
import com.github.cschulc.jirarestservice.domain.Priority;
import com.github.cschulc.jirarestservice.domain.Status;
import com.github.cschulc.jirarestservice.domain.avatar.AvatarType;
import com.github.cschulc.jirarestservice.domain.avatar.SystemAvatars;
import com.github.cschulc.jirarestservice.domain.field.CreateField;
import com.github.cschulc.jirarestservice.domain.field.Field;
import com.github.cschulc.jirarestservice.domain.system.Configuration;

import java.util.List;
import java.util.concurrent.Future;

public interface SystemService {

    /**
     * Return the Configuration of the remote Jira Instanz
     *
     * @return Configuration
     */
    Future<Configuration> getConfiguration();

    /**
     * Returns a list of all issue types visible to the connected client.
     *
     * @return list of issue types
     */
    Future<List<Issuetype>> getIssueTypes();

    /**
     * Returns a list of all statuses.
     *
     * @return list of statuses
     */
    Future<List<Status>> getStates();


    /**
     * Returns a List of all Priority Object from the Remote Jira.
     *
     * @return
     */
    Future<List<Priority>> getPriorities();


    /**
     * Return a List of all FieldEnum configure in Jira, standard and custom
     *
     * @return a List of FieldEnum
     */
    Future<List<Field>> getAllFields();


    /**
     * Return all Custom FieldEnum configure in the Jira
     *
     * @return a List of FieldEnum
     */
    Future<List<Field>> getAllCustomFields();

    /**
     * Return a Custom FieldEnum by Id
     *
     */
    Future<Field> getCustomFieldById(String id);


    /**
     * Get the Attachment Meta Information for the jira instanz
     *
     * @return AttachmentMeta
     */
    Future<AttachmentMeta> getAttachmentMeta();

    /**
     * Creates a Custom FieldEnum
     *
     * @param fieldBean The CreateField with the create Informations
     * @return The created FieldEnum as FieldEnum
     */
    Future<Field> createCustomField(CreateField fieldBean);

    /**
     * Returns all system avatars of the given type.
     *
     * @param avatarType The {@link AvatarType}
     * @return SystemAvatars with a List of {@link com.github.cschulc.jirarestservice.domain.avatar.Avatar}
     */
    Future<SystemAvatars> getAllSystemAvatars(AvatarType avatarType);
}
