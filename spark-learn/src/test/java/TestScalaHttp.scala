import org.bouncycastle.util.test.Test
import scalaj.http.Http

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

/**
 * @authorliyunfei
 * @date2022/12/1
 * */
object TestScalaHttp {
   @Test
   def testHttp(): Unit ={
      var ss = Http("http://www.baidu.com/").asString;
      println(ss);
   }
}
