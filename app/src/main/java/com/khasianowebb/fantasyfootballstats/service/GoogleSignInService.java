package com.khasianowebb.fantasyfootballstats.service;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

/**
 * The type Google sign in service.
 */
public class GoogleSignInService {

  private static Application applicationContext;

  private GoogleSignInClient client;
  private MutableLiveData<GoogleSignInAccount> account = new MutableLiveData<>();
  private MutableLiveData<Exception> exception = new MutableLiveData<>();

  private GoogleSignInService() {
    GoogleSignInOptions options = new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .requestProfile()
        // .requestIdToken(...)
        .build();
    client = GoogleSignIn.getClient(applicationContext, options);
  }

  /**
   * Sets application context with public static void setApplication.
   *
   * @param applicationContext the application context with public static void setApplication.
   */
  public static void setApplicationContext(Application applicationContext) {
    GoogleSignInService.applicationContext = applicationContext;
  }

  /**
   * Gets instance of the public static GoogleSignInService for getInstance.
   *
   * @return the instance of the public static GoogleSignInService for getInstance.
   */
  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Gets account of the public LiveData with GoogleSignInAccount.
   *
   * @return the account of the public LiveData with GoogleSignInAccount.
   */
  public LiveData<GoogleSignInAccount> getAccount() {
    return account;
  }

  /**
   * Gets exception of public LiveData with exception.
   *
   * @return the exception of public LiveData with exception.
   */
  public LiveData<Exception> getException() {
    return exception;
  }

  /**
   * Refresh task of the public GoogleSignInAccount with refresh.
   *
   * @return the task of the public GoogleSignInAccount with refresh.
   */
  public Task<GoogleSignInAccount> refresh() {
    return client.silentSignIn()
        .addOnSuccessListener(this::update)
        .addOnFailureListener(this::update);
  }

  private void update(GoogleSignInAccount account) {
    this.account.setValue(account);
    this.exception.setValue(null);
  }

  private void update(Exception ex) {
    account.setValue(null);
    exception.setValue(ex);
  }

  /**
   * Starts GoogleSignIn activity.
   *
   * @param activity    the activity of the GoogleSignIn is taking place.
   * @param requestCode the request code of the startActivity is done.
   */
  public void startsSignIn(Activity activity, int requestCode) {
    update((GoogleSignInAccount) null);
    Intent intent = client.getSignInIntent();
    activity.startActivityForResult(intent, requestCode);
  }

  /**
   * Complete the GoogleSignIn task.
   *
   * @param data the data for the complete SignIn.
   * @return the task of GoogleSignIn done so.
   */
  public Task<GoogleSignInAccount> completeSignIn(Intent data) {
    Task<GoogleSignInAccount> task = null;
    try {
      task = GoogleSignIn.getSignedInAccountFromIntent(data);
      account.setValue(task.getResult(ApiException.class));
    } catch (ApiException e) {
      update(e);
    }
    return task;
  }

  /**
   * The GoogleSignOut task is started at this point.
   *
   * @return the task of the GoogleSignOut is taking place.
   */
  public Task<Void> signOut() {
    return client.signOut()
        .addOnCompleteListener((account) -> update((GoogleSignInAccount) null));
  }

  private static class InstanceHolder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();

  }
}
