/*
	Coded by timemachine on 18-6-4
	MxCompiler.Optim.IRInliner
*/


package MxCompiler.Optim;

import MxCompiler.AST.FunDefNode;
import MxCompiler.AST.FuncallNode;
import MxCompiler.CodeGen.IRBuilder;
import MxCompiler.Global;
import MxCompiler.IR.*;
import MxCompiler.SemanticCheck.ASTree;
import MxCompiler.tools.Debuger;

import java.util.*;

public class IRInliner implements IRVisitor
{
	private List<List<InsIR>> irLists;
	//private List<List<InsIR>> irlists;
	private List<InsIR> newList;

	private int regNumber;
	private int leftInline, totalLines;
	private boolean inlined, stopInline;

	private ASTree ast;


	public IRInliner(List<List<InsIR>> irLists, ASTree ast)
	{
		this.irLists = irLists;
		this.ast = ast;
	}

	public List<List<InsIR>> getInline()
	{
		List<List<InsIR>> lists;
		final int lineLimit = 2048;
		final int regLimit = 1000;
		int maxReg = Global.maxRegNumber;
		leftInline = 1;
		if(ASTConstFolding.cf_count > 50)
			leftInline = 0;
		totalLines = 0;
		stopInline = false;

		while(leftInline > 0 && totalLines < lineLimit && maxReg < regLimit &&
				regNumber < regLimit )
		{
			lists = new ArrayList<List<InsIR>>();
			inlined = false;
			int idx = 0;
			for(List<InsIR> list: irLists)
			{
				regNumber = Global.regNumber.get(idx);
				newList = new ArrayList<>();
				//Debuger.printInfo("952",""+regNumber);
				for(InsIR i: list)
				if(i instanceof CallIR && maxReg < regLimit){
					int backReg = regNumber;

					List<InsIR> l = visitCall((CallIR) i);
					if(regNumber > regLimit && ((CallIR) i).funNode()!=null )
					{
						newList.add(i);
						maxReg = Math.max(maxReg, regNumber);
						regNumber = backReg;
						//Global.maxRegNumber = Math.max(regNumber.);
					}else
					{
						newList.addAll(l);
					}
					//i.accept(this);
				}else
					newList.add(i);
				lists.add(newList);
				Global.regNumber.set(idx, regNumber);
				//Debuger.printInfo("952",""+regNumber);
				idx++;
				totalLines += newList.size();
				//Debuger.printInfo("totalLines", ""+totalLines);
				//Debuger.printInfo("regLimit", ""+regLimit);
			}
			irLists = lists;
			if(!inlined)
				break;
			leftInline--;
		}

		//End all
		stopInline = true;

		lists = new ArrayList<List<InsIR>>();
		inlined = false;
		int idx = 0;
		for(List<InsIR> list: irLists)
		{
			regNumber = Global.regNumber.get(idx);
			newList = new ArrayList<>();
			for(InsIR i: list)
				if(i instanceof CallIR){
					newList.addAll(visitCall((CallIR) i));
				}else
					newList.add(i);
			lists.add(newList);
			Global.regNumber.set(idx, regNumber);
			idx++;
		}
		irLists = lists;

		return irLists;
	}

	private List<InsIR> visitCall(CallIR node)
	{
		inlined = true;
		//node.setPlist(visitPList(node.plist()));

		IRBuilder reBuilder = new IRBuilder(ast);
		reBuilder.savedRegNumber= regNumber;
		List<InsIR> list = new ArrayList<>();
		if(node.funName() == null)
		{
			list.add(node);
		}else if(stopInline || node.funNode() == null)
		{
			//code use lib | compiler use lib
			if(stopInline)
			{
				reBuilder.nowInline = false;
				list = reBuilder.funcIR(node);
			}else
				list.add(node);
		}else
		{
			list = reBuilder.funcIR(node.funNode(), node.plist(), node.dest());
		}


		regNumber += reBuilder.regNumber-16;
		return list;
	}
	@Override
	public void visit(CallIR node)
	{

	}

	@Override
	public void visit(AlignIR node)
	{

	}

	@Override
	public void visit(TriIR node)
	{

	}

	@Override
	public void visit(BinaryIR node)
	{

	}

	@Override
	public void visit(UnaryIR node)
	{

	}

	@Override
	public void visit(CJumpIR node)
	{

	}

	@Override
	public void visit(JumpIR node)
	{

	}


	@Override
	public void visit(LabelIR node)
	{

	}

	@Override
	public void visit(ReturnIR node)
	{

	}

	@Override
	public void visit(PushIR node)
	{

	}

	@Override
	public void visit(PopIR node)
	{

	}

	@Override
	public void visit(LoadIR node)
	{

	}

	@Override
	public void visit(StoreIR node)
	{

	}

	@Override
	public void visit(MoveIR node)
	{

	}

	@Override
	public void visit(SpecialIR node)
	{

	}
}
