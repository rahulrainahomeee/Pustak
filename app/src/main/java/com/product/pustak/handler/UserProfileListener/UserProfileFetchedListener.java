package com.product.pustak.handler.UserProfileListener;

import com.product.pustak.handler.UserProfileHandler.UserProfileHandler;
import com.product.pustak.model.User;

/**
 * Interface for listening for user profile listener.
 */
public interface UserProfileFetchedListener {

    /**
     * Callback method to notify about profile information fetching response.
     *
     * @param user    {@link User} reference
     * @param code    {@link com.product.pustak.handler.BaseHandler.BaseHandler.CODE}
     * @param message {@link String}
     */
    void userProfileFetchedCallback(User user, UserProfileHandler.CODE code, String message);

}
