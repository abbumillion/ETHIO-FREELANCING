package mngmnt.controller;

import mngmnt.ServiceImp.FeedbackServiceImp;
import mngmnt.dto.FeedbackDTO;
import mngmnt.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class FeedbackController {
    private FeedbackServiceImp feedbackServiceImp;
    @Autowired
    public FeedbackController(FeedbackServiceImp feedbackServiceImp)
    {
        this.feedbackServiceImp = feedbackServiceImp;
    }
    @RequestMapping("/api/add_feedback")
    public String add_feedback(FeedbackDTO feedbackDTO) {
//        System.out.println("add feedback controller");
//        System.out.println(feedbackModel.getId());
//        System.out.println(feedbackModel.getContent());
//        System.out.println(feedbackModel.getDate());
//        feedbackServiceImp.add_feedback(feedbackModel);
        return "addskill.jsp";
    }

    @RequestMapping("/api/get_feedback")
    public Feedback get_feedback(long id) {
        return feedbackServiceImp.get_feedback(id);
    }

    @RequestMapping("/api/feedbacks")
    public List<Feedback> feedbacks()
    {
        return  feedbackServiceImp.all_feedback();
    }
    @RequestMapping("/api/delete_feedback")
    public String delete_feedback(long id)
    {
        feedbackServiceImp.delete_feedback(id);
        return "addskill.jsp";
    }
    @RequestMapping("/api/delete_all_feedback")
    public String delete_all_feedback()
    {
        feedbackServiceImp.delete_all();
        return "addskill.jsp";
    }
}
