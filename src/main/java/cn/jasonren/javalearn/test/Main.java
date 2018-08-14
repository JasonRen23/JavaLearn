package cn.jasonren.javalearn.test;

/**
 * @author zhicheng
 * @create 2018-07-13 下午7:24
 */


public class Main {
    public static void main(String[] args) {

        EContext eContext = new EContext();

        eContext

                .extractor.new HelpExtractor();
    }
}
