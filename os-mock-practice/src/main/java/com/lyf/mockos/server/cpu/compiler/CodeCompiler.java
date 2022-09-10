package com.lyf.mockos.server.cpu.compiler;

/**
 * 代码编译
 *
 * @author liyunfei
 */
public class CodeCompiler {
    
    private CompilerService delegate;
    
    public CodeCompiler(CompilerService delegate) {
        if (delegate instanceof CppCompiler) {
            this.delegate = new CppCompiler();
        } else if (delegate instanceof JavaCompiler) {
            this.delegate = new JavaCompiler();
        }
        this.delegate = delegate;
    }
}
