package mngmnt.service;


import mngmnt.model.Feedback;

import java.util.List;

public interface FeedbackService {
    void add_feedback(Feedback feedbackModel);
    Feedback get_feedback(long id);
    List<Feedback> all_feedback();
    void delete_feedback(long id);
    void delete_all();
}
