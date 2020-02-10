/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.symbols.internal.impl.ast;

import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourceforge.pmd.lang.java.ast.ASTVariableDeclaratorId;
import net.sourceforge.pmd.lang.java.ast.JModifier;
import net.sourceforge.pmd.lang.java.symbols.JClassSymbol;
import net.sourceforge.pmd.lang.java.symbols.JFieldSymbol;
import net.sourceforge.pmd.lang.java.symbols.internal.impl.SymbolEquality;
import net.sourceforge.pmd.lang.java.symbols.internal.impl.SymbolToStrings;

final class AstFieldSym extends AbstractAstVariableSym implements JFieldSymbol {


    private final JClassSymbol owner;

    AstFieldSym(ASTVariableDeclaratorId node,
                       AstSymFactory factory,
                       JClassSymbol owner) {
        super(node, factory);
        this.owner = owner;
    }

    @Override
    public int getModifiers() {
        return JModifier.toReflect(node.getModifiers().getEffectiveModifiers());
    }

    @Override
    public boolean isEnumConstant() {
        return node.isEnumConstant();
    }

    @Override
    public @NonNull JClassSymbol getEnclosingClass() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        return SymbolEquality.FIELD.equals(this, o);
    }

    @Override
    public int hashCode() {
        return SymbolEquality.FIELD.hash(this);
    }


    @Override
    public String toString() {
        return SymbolToStrings.AST.fieldToString(this);
    }

}
