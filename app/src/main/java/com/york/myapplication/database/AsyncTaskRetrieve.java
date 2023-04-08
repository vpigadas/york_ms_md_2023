package com.york.myapplication.database;

import android.os.AsyncTask;

import java.util.List;

public class AsyncTaskRetrieve extends AsyncTask<UserEntity,Void, List<UserEntity>> {

    interface Listener {
        public void onSuccess(List<UserEntity> array);
    }

    private Listener listener;
    private DatabaseIntance dbInstance;

    public AsyncTaskRetrieve(Listener listener, DatabaseIntance dbInstance) {
        this.listener = listener;
        this.dbInstance = dbInstance;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<UserEntity> doInBackground(UserEntity... users) {
        return dbInstance.getUserDao().get();
//        return dbInstance.getUserDao().save(users);
    }

    @Override
    protected void onPostExecute(List<UserEntity> userEntities) {
        super.onPostExecute(userEntities);
        listener.onSuccess(userEntities);
    }
}
