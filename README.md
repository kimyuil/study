# study

1. make calcurator by Vanilla
2. make structure about worship
3. make download service

### vscode로 메이븐이나 그래들 없이 작업 할때

디펜던시를 추가하는 과정에서 생각해야할 것들이 있다

1. https://www.apache.org/dyn/closer.lua/poi/release/bin/poi-bin-5.0.0-20210120.zip 에서 http 다운로드 받고 원하는 위치에 압축해제
2. File -> Preference -> setting -> java.project. 정도 검색 후 json으로 수정 클릭
3. "java.project.referencedLibraries": [
   "..\\dependency\\poi-5.0.0\\*",
   "..\\dependency\\poi-5.0.0\\lib\\*",
   "..\\dependency\\poi-5.0.0\\ooxml-lib\\*"
   ] jar 파일의 위치를 잡아준다.
   3개 모두 해주어야 에러가 나지 않는다!

   vscode로 프로젝트를 연 곳이 기준점이기 때문에 위의 코드로 에러가 나지 않으려면 csvService폴더에서 vscode 프로젝트를 열어야한다.

   절대경로도 가능함.
