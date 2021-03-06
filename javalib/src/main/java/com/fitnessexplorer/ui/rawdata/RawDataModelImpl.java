package com.fitnessexplorer.ui.rawdata;

import com.fitnessexplorer.services.repo.RepositoryState;
import com.fitnessexplorer.services.repo.preferences.IPreferencesRepository;
import com.fitnessexplorer.services.task.ITaskScheduler;
import com.fitnessexplorer.ui.base.BaseModel;
import com.fitnessexplorer.services.repo.IFitnessRepository;

/**
 * Created by David.Bickford on 5/24/2016.
 */
public class RawDataModelImpl extends BaseModel<IRawDataView, IRawDataController> implements IRawDataModel
{

    public RawDataModelImpl(IFitnessRepository repo, IPreferencesRepository preferencesRepo, ITaskScheduler taskScheduler, IRawDataController controller)
    {
        super(repo, preferencesRepo, taskScheduler, controller);
    }

    @Override
    public void viewReady(IRawDataView view)
    {
        super.viewReady(view);
    }

    @Override
    public void onRepositoryStateChanged(RepositoryState oldState, RepositoryState newState)
    {
        if(newState == RepositoryState.CONNECTING)
        {
            view.showConnecting();
        }
        else if(newState == RepositoryState.CONNECTION_SUCCESS)
        {
            view.showData();
        }
    }
}
