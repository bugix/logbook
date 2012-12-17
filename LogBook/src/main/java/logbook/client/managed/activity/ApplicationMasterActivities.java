package logbook.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.KeywordProxy;
import logbook.client.managed.proxy.MainClassificationProxy;
import logbook.client.managed.proxy.SkilAcquiredProxy;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.SkillLevelProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.StudentProxy;
import logbook.client.managed.proxy.TopicProxy;
import logbook.client.managed.request.ApplicationEntityTypesProcessor;
import logbook.client.managed.request.ApplicationRequestFactory;
import logbook.client.managed.ui.ClassificationTopicListView;
import logbook.client.managed.ui.ClassificationTopicMobileListView;
import logbook.client.managed.ui.KeywordListView;
import logbook.client.managed.ui.KeywordMobileListView;
import logbook.client.managed.ui.MainClassificationListView;
import logbook.client.managed.ui.MainClassificationMobileListView;
import logbook.client.managed.ui.SkilAcquiredListView;
import logbook.client.managed.ui.SkilAcquiredMobileListView;
import logbook.client.managed.ui.SkillAcquiredListView;
import logbook.client.managed.ui.SkillAcquiredMobileListView;
import logbook.client.managed.ui.SkillLevelListView;
import logbook.client.managed.ui.SkillLevelMobileListView;
import logbook.client.managed.ui.SkillListView;
import logbook.client.managed.ui.SkillMobileListView;
import logbook.client.managed.ui.StudentListView;
import logbook.client.managed.ui.StudentMobileListView;
import logbook.client.managed.ui.TopicListView;
import logbook.client.managed.ui.TopicMobileListView;
import logbook.client.scaffold.ScaffoldApp;
import logbook.client.scaffold.place.ProxyListPlace;

public final class ApplicationMasterActivities extends ApplicationMasterActivities_Roo_Gwt {

    @Inject
    public ApplicationMasterActivities(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }
}
