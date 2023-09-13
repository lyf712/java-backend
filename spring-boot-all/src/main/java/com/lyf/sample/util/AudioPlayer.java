/*
 *    Copyright 1999-2022  lyf712
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.lyf.sample.util;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

/**
 * @see <a href="https://tzg.ylzmjd.com/user/?laiurl=https://tzg.ylzmjd.com/18/4382.html">参考下载音乐网</a>
 *
 * @author liyunfei
 **/
public class AudioPlayer {

    static String audioFilePath = "E:\\JavaProjects\\LearnProjects\\java-backend\\spring-boot-all\\src\\main\\resources\\music\\audiofile.wav";

    public static void main(String[] args) {
        // record();
        play(audioFilePath);
    }

    public static void record(){
        try {
            // 指定音频文件路径

            // 设置音频格式
            AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);

            // 获取音频输入设备
            TargetDataLine targetDataLine = AudioSystem.getTargetDataLine(audioFormat);
            targetDataLine.open(audioFormat);
            System.out.println("开始录制");
            targetDataLine.start();
            TimeUnit.SECONDS.sleep(10);
            targetDataLine.stop();

            // 创建音频输入流
            AudioInputStream audioInputStream = new AudioInputStream(targetDataLine);

            // 开始录制音频
            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, new File(audioFilePath));

            // 关闭音频输入流和设备
            audioInputStream.close();
            targetDataLine.stop();
            targetDataLine.close();

            System.out.println("录制完成：" + audioFilePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //audiofile.wav
    public static void play(String audioFilePath){
        try {
            // 获取音频输入流AudioPlayer.class.getResourceAsStream(audioFilePath) AudioPlayer.class.getResourceAsStream(audioFilePath)
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audioFilePath));

            // 获取音频格式
            AudioFormat format = audioInputStream.getFormat();
            System.out.println("xxx:"+format.toString());

            // 创建数据行信息
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            // 打开数据行
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceDataLine.open(format);
            System.out.println(sourceDataLine.getLevel());

            // 开始播放音频
            sourceDataLine.start();

            byte[] buffer = new byte[4096];
            int bytesRead;

            // 读取音频数据并播放
            while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                sourceDataLine.write(buffer, 0, bytesRead);
            }

            // 关闭数据行和音频输入流
            sourceDataLine.drain();
            sourceDataLine.close();
            audioInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
