package mngmnt.ServiceImp;

import mngmnt.model.Feedback;
import mngmnt.repository.FeedbackRepo;
import mngmnt.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImp implements FeedbackService {
    private FeedbackRepo feedbackRepo;
    @Autowired
    public FeedbackServiceImp(FeedbackRepo feedbackRepo)
    {
        this.feedbackRepo = feedbackRepo;
    }

    @Override
    public void add_feedback(Feedback feedback) {
        feedbackRepo.save(feedback);
    }

    @Override
    public Feedback get_feedback(long id)
    {
        return null;
    }

    @Override
    public List<Feedback> all_feedback() {
        return null;
    }

    @Override
    public void delete_feedback(long id) {
        feedbackRepo.deleteById(id);
    }

    @Override
    public void delete_all() {
        feedbackRepo.deleteAll();
    }
}
