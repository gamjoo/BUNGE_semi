package common;

import java.io.IOException;
import java.sql.SQLException;

import chat.action.*;
import comment.action.CommentAddAction;
import comment.action.CommentDeleteAction;
import comment.action.CommentListAction;
import comment.action.CommentReplyAction;
import comment.action.CommentUpdateAction;
import common.action.Action;
import common.action.ActionForward;
import common.join.emailcheckAction;
import common.join.idcheckAction;
import common.join.joinAction;
import common.join.joinProcessAction;
import common.join.nickcheckAction;
import common.login.findidAction;
import common.login.findidProcessAction;
import common.login.findpwdAction;
import common.login.findpwdProcessAction;
import common.login.loginAction;
import common.login.loginProcessAction;
import common.login.logoutAction;
import common.login.pwdresetAction;
import common.mypage.mycommlistAction;
import common.mypage.mycommlistprocessAction;
import common.mypage.mylikelistAction;
import common.mypage.mypageAction;
import common.mypage.mypageReviewAction;
import common.mypage.mypagechangeAction;
import common.mypage.mytradelistAction;
import header.action.HeaderProfileAciton;
import info.action.InfoDetailAction;
import info.action.InfoListAction;
import info.action.InfoModifyAction;
import info.action.InfoModifyProcessAction;
//import info.action.InfoModifyProcessAction;
import info.action.InfoReplyAction;
import info.action.InfoReplyProcessAction;
import info.action.InfoAddAction;
import info.action.InfoBoardFileDownAction;
import info.action.InfoDeleteAction;
import info.action.InfoWriteAction;
import info.action.InfobooksearchAction;
import infoboardlike.action.InfoLikeCntAction;
import infoboardlike.action.InfoLikeAddAction;
import infoboardlike.action.InfoLikeDeleteAction;
import infocommlike.action.InfocommLikeAddAction;
import infocommlike.action.InfocommLikeCntAction;
import infocommlike.action.InfocommLikeDeleteAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mainpage.action.MainPopularBookAciton;
import mainpage.action.MainPopularCommAction;
import mainpage.action.MainPopularPostAction;
import mainpage.action.MainTradeAction;

import javax.naming.NamingException;


@WebServlet("*.com")
public class FrontController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doProcess(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException, SQLException, NamingException {

        String RequestURI = request.getRequestURI();
        System.out.println("RequestURI = " + RequestURI);

        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);

        String command = RequestURI.substring(contextPath.length());
        System.out.println("command = " + command);

        ActionForward forward = null;
        Action action = null;

        switch (command) {
            //로그인
            case "/login.com":
                action = new loginAction();
                break;
            case "/loginProcess.com":
                action = new loginProcessAction();
                break;
            //로그아웃
            case "/logout.com":
                action = new logoutAction();
                break;
                //회원가입 페이지
            case "/join.com":
                action = new joinAction();
                break;
            case "/joinProcess.com":
                action = new joinProcessAction();
                break;
            //아이디 중복 검사
            case "/idcheck.com":
                action = new idcheckAction();
                break;
            //닉네임 중복 검사
            case "/nickcheck.com":
                action = new nickcheckAction();
                break;
            //이메일 중복 검사
            case "/emailcheck.com":
                action = new emailcheckAction();
                break;
            //아이디 찾기
            case "/findid.com":
                action = new findidAction();
                break;
            case "/findidProcess.com":
                action = new findidProcessAction();
                break;
            //비밀번호 찾기
            case "/findpwd.com":
                action = new findpwdAction();
                break;
            case "/findpwdProcess.com":
                action = new findpwdProcessAction();
                break;
            //비밀번호 재설정
            case "/pwdreset.com":
                action = new pwdresetAction();
                break;
            //내 정보 수정 페이지
            case "/mypage.com":
                action = new mypageAction();
                break;
            case "/mypagechange.com" :
            	action = new mypagechangeAction();
            	break;
            case "/reviewlist.com" :
            	action = new mypageReviewAction();
            	break;
            	//내가 쓴 댓글 페이지
            case "/mycommlist.com" :
            	action = new mycommlistAction();
            	break;
            //마이페이지 댓글 리스트 처리
            case "/mycommlistprocess.com" :
            	action = new mycommlistprocessAction();
            	break;
            	//즐겨찾기 페이지
            case "/mylikelist.com" :
            	action = new mylikelistAction();
            	break;
            	//중고거래 좋아요(찜) 페이지
            case"/mytradelist.com" :
            	action = new mytradelistAction();
            	break;
            //게시판에 글 추가
            case "/InfoAdd.com":
                action = new InfoAddAction();
                break;
            //글쓰기
            case "/InfoWrite.com":
                action = new InfoWriteAction();
                break;
            //게시글 목록
            case "/InfoList.com":
                action = new InfoListAction();
                break;
            //게시글 상세페이지
            case "/InfoDetail.com":
                action = new InfoDetailAction();
                break;
            //게시글 삭제
            case "/InfoDelete.com":
                action = new InfoDeleteAction();
                break;
            //게시판 글 수정
            case "/InfoModify.com":
                action = new InfoModifyAction();
                break;
            //게시판 글 수정 등록
            case "/InfoModifyProcess.com":
                action = new InfoModifyProcessAction();
                break;
            //답글 글쓰기로 가기
            case "/InfoReply.com":
                action = new InfoReplyAction();
                break;
            //답글 글쓰기 등록까지
            case "/InfoReplyProcess.com":
                action = new InfoReplyProcessAction();
                break;
            //댓글 등록
            case "/CommentAdd.com":
                action = new CommentAddAction();
                break;
            //댓글 목록
            case "/CommentList.com":
                action = new CommentListAction();
                break;
            //댓글 삭제
            case "/CommentDelete.com":
                action = new CommentDeleteAction();
                break;
            //댓글 수정
            case "/CommentUpdate.com":
                action = new CommentUpdateAction();
                break;
            //대댓글
            case "/CommentReply.com":
                action = new CommentReplyAction();
                break;
            //게시글 좋아요 카운트
            case "/InfoLikeCnt.com":
                action = new InfoLikeCntAction();
                break;
            // 좋아요 추가
            case "/InfoLikeAdd.com":
                action = new InfoLikeAddAction();
                break;
             // 좋아요 삭제
            case "/InfoLikeDelete.com":
                action = new InfoLikeDeleteAction();
                break;												
            //채팅 페이지 이동
            case "/chat.com":
                action = new ChatListAction();
                break;
            //채팅 리스트 불러오기
            case "/chatLoad.com":
                action = new ChatListLoadAction();
                break;
            //임시 채팅방 입장 페이지
            case "/chatEnter.com":
                action = new ChatEnterAction();
                break;
            //채팅방 생성
            case "/chatCreate.com":
                action = new ChatCreateAction();
                break;
            //채팅방 삭제
            case "/chatDelete.com":
                action = new ChatDeleteAction();
                break;
            //보낸 메세지 저장
            case "/messageStore.com":
                action = new MessageStoreAciton();
                break;
            //저장된 메세지 불러오기
            case "/messageLoad.com":
                action = new MessageLoadAction();
                break;
            //댓글 좋아요 추가
            case "/InfocommLikeCnt.com":
            	action = new InfocommLikeCntAction();
            	break;
            //댓글 좋아요 추가
            case "/InfocommLikeAdd.com":
            	action = new InfocommLikeAddAction();
            	break;
            //댓글 좋아요 삭제
            case "/InfocommLikeDelete.com":
            	action = new InfocommLikeDeleteAction();
            	break;
            //첨부파일 저장
            case "/InfoBoardFileDown.com":
            	action = new InfoBoardFileDownAction();
            	break;
            //책 검색 결과
            case "/Infobooksearch.com":
            	action = new InfobooksearchAction();
            	break;
            //가장 인기 있는 책
            case "/MainPopularBook.com":
            	action = new MainPopularBookAciton();
            	break;
            //가장 인기 있는 댓글
            case "/MainPopularComm.com":
            	action = new MainPopularCommAction();
            	break;
            //인기 게시글
            case "/MainPopularPost.com":
            	action = new MainPopularPostAction();
            	break;
            //헤더 프로필
            case "/HeaderProfile.com":
            	action = new HeaderProfileAciton();
            	break;
            //거래 게시판 진행중인 거래
            case "/MainTrade.com" :
            	action = new MainTradeAction();
            	break;

        } //switch (command)

        forward = action.execute(request, response);

        if (forward != null) {
            if (forward.isRedirect()) {
                response.sendRedirect(forward.getPath());
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
                dispatcher.forward(request, response);
            }
        }//if (forward != null)
    } //doProcess

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            doProcess(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            doProcess(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
