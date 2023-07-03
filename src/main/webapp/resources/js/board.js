// list
let newbtn = document.querySelector("#newbtn");
newbtn?.addEventListener('click', ()=>{
    location.href = '/board/write';

});

//write

let newbdbtn = document.querySelector("#newbdbtn");
newbdbtn?.addEventListener('click', () => {
    let frm=document.forms.writefrm;

    if (frm.title.value === '') {
        alert('제목을 작성하세요')
    } else if (frm.contents.value === '') {
        alert('본문을 작성하세요');
    }else if(grecaptcha.getResponse() === '') {
        alert('자동쓰기방지를 체크하세요!!')
    }else {
        frm.method = 'post';
        frm.submit();
            // wirte.jsp에서 name을 가져옴
    }

});