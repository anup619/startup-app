package com.example.startup_app.Core.Registration;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegistrationInteractor implements RegistrationContract.Intractor {
    private DatabaseReference documentReference;

    private RegistrationContract.onRegistrationListener mOnRegistrationListener;

    public RegistrationInteractor(RegistrationContract.onRegistrationListener onRegistrationListener){
        this.mOnRegistrationListener = onRegistrationListener;
    }

    @Override
    public void performFirebaseRegister(Activity activity, String email, String password, final String name, final String phoneNumber, final String grade) {
        FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Create User Email", "createUserWithEmail:success");


                            FirebaseUser fuser = FirebaseAuth.getInstance().getCurrentUser();
                            final String userid = fuser.getUid();
                            documentReference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                            HashMap<String,String> hashmap = new HashMap<>();
                            hashmap.put("id",userid);
                            hashmap.put("name",name);
                            hashmap.put("phone",phoneNumber);
                            hashmap.put("class",grade);
                            hashmap.put("image_url","default");

                            documentReference.setValue(hashmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Log.d("TAG","Data Pushed");
                                    } else {
                                        Log.d("TAG","data not pushed");
                                    }
                                }
                            });
                            mOnRegistrationListener.onSuccess(task.getResult().toString());

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Create User Email", "createUserWithEmail:failure", task.getException());
                            mOnRegistrationListener.onFailure(task.getException().toString());
                        }
                    }
                });
    }
}
