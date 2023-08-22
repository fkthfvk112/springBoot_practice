import React, {useState} from 'react';
import axios from 'axios';
import {ReactMediaRecorder} from 'react-media-recorder';
import Tts from './Tts';

function App() {
  const [resp, setResp] = useState('');

  const onSubmit = (e) =>{
    e.preventDefault();
    let formData = new FormData();
    formData.append('uploadFile', document.frm.uploadFile.files[0]);

    // send
    axios.post("http://localhost:3000/fileUpload", formData)
      .then(res=>{
        console.log(res.data);
        setResp(res.data.text);
      })
      .catch(e=>{
        alert(e);
      })
  }
  return (
    <div style={{textAlign:'center'}}>
      <Tts></Tts>
      <ReactMediaRecorder
        audio
        render={({status, startRecording, stopRecording, mediaBlobUrl})=>(
          <div>
            <p>{status}</p>
            <button onClick={startRecording}>녹음 시작</button>
            <button onClick={stopRecording}>녹음 중지</button><br/><br/>
            <audio src={mediaBlobUrl} controls></audio><br/>

            {/* 다운로드링크 */}
            <a href={mediaBlobUrl} download='my-audio-file.wav'>download</a>
          </div>
        )}
        />
        <hr />
        <h2>음성파일 업로드</h2>
        <form name='frm' onSubmit={onSubmit} encType='multipart/form-data'>
          <input type="file" name ='uploadFile' accept='*' />
          <input type="submit" value='파일 전송'/>
        </form>
        <p>결과 {resp}</p>
    </div>
  )
}

export default App
