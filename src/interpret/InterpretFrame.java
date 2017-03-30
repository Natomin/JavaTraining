package interpret;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.Field;

import jpl.ch13.ex02.StringCounter;

public class InterpretFrame extends Frame {
	//TODO 配列オブジェクト作成・表示、実行結果表示、例外表示、
	
	private static final long serialVersionUID = 1L;
	private Class<?> type;
	private Constructor<?>[] allConstracter;
	private Field[] allField;
	private Method[] allMethod;
	private java.util.List<Object> allInstance = new ArrayList<>();
	private int instNum;

	public InterpretFrame() {
		super("Interpret");
		setSize(650, 700);
		setResizable(true);
		setLayout(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {// ×押された時の処理
				System.exit(0);// 閉じる
			}
		});
		// クラス名入力部分
		TextField classNameField = new TextField("class name");
		classNameField.setBounds(10, 40, 230, 30);
		add(classNameField);

		// ラベル
		Label labelConst = new Label("constractor list");
		labelConst.setBounds(10, 80, 100, 20);
		add(labelConst);
		// コンストラクタリスト
		List constList = new List();
		constList.setBounds(10, 100, 300, 200);
		add(constList);

		// ラベル
		Label labelOutput = new Label("execution result");
		labelOutput.setBounds(330, 80, 150, 20);
		add(labelOutput);
		// execute result（結果出力）
		TextArea output = new TextArea("", 100, 100, TextArea.SCROLLBARS_BOTH);
		output.setBounds(330, 100, 310, 250);
		add(output);

		// getボタン（コンストラクタ情報取得）
		Button getC = new Button("get");
		getC.setBounds(245, 40, 70, 30);
		add(getC);
		getC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				constList.removeAll();
				String className = classNameField.getText();
				// ToDo null check
				try {
					type = Class.forName(className);
					allConstracter = type.getDeclaredConstructors();
					for (Constructor<?> c : allConstracter) {
						constList.add(c.toString());
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					// ToDo catch処理追加
				}
			}
		});
		// パラメーター入力部分
		TextField paramsField = new TextField("params");
		paramsField.setBounds(10, 320, 230, 30);
		add(paramsField);

		// ラベル
		Label labelInst = new Label("instance list");
		labelInst.setBounds(10, 360, 100, 20);
		add(labelInst);
		// インスタンスリスト
		List instanceList = new List();
		instanceList.setBounds(10, 380, 630, 100);
		add(instanceList);

		// createボタン（インスタンス生成）
		Button createInst = new Button("create");
		createInst.setBounds(245, 320, 70, 30);
		add(createInst);
		createInst.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = constList.getSelectedIndex();// 選択されている項目のIndex取得
				java.lang.reflect.Type[] paramTypes = allConstracter[selectedIndex].getGenericParameterTypes();// コンストラクタの引数の型
				Object[] params = new Object[paramTypes.length];// 引数を格納する配列
				params = toParamArr(paramsField.getText());// 入力されたパラメーター文字列をobject配列に変換

				if (paramTypes.length == params.length) {
					try {
						// TODO パラメーターの型チェック
						if (params.length == 0) {
							allInstance.add(allConstracter[selectedIndex].newInstance());
						} else {
							allInstance.add(allConstracter[selectedIndex].newInstance(params));
						}
						instanceList.add("#" + instNum + " "
								+ allConstracter[selectedIndex].getDeclaringClass().getSimpleName());
						instNum++;
					} catch (InstantiationException e1) {
						// TODO 自動生成された catch ブロック
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO 自動生成された catch ブロック
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						// TODO 自動生成された catch ブロック
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						// TODO 自動生成された catch ブロック
						e1.printStackTrace();
					}
				} else {
					// 入力パラメータが不正
					// TODO
				}
			}
		});

		// ラベル
		Label labelField = new Label("instance field list");
		labelField.setBounds(10, 510, 180, 20);
		add(labelField);
		// フィールドリスト
		List fieldList = new List();
		fieldList.setBounds(10, 530, 300, 100);
		add(fieldList);

		// getボタン（フィールド情報取得）
		Button getF = new Button("get");
		getF.setBounds(245, 500, 70, 30);
		add(getF);
		getF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fieldList.removeAll();
				int selectedIndex = instanceList.getSelectedIndex();// 選択されているインスタンスのIndex取得
				Object selectedInst = allInstance.get(selectedIndex);
				Class<?> selectedInstType = selectedInst.getClass();

				allField = selectedInstType.getDeclaredFields();
				// TODO 全てのフィールドを取得する
				for (Field f : allField) {
					f.setAccessible(true);
					try {
						fieldList.add(f.getName() + ":" + f.get(selectedInst));
					} catch (IllegalArgumentException e1) {
						// TODO 自動生成された catch ブロック
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO 自動生成された catch ブロック
						e1.printStackTrace();
					}
				}
			}
		});

		// フィールド値入力部分
		TextField newField = new TextField("new value");
		newField.setBounds(10, 635, 230, 30);
		add(newField);
		// changeボタン（フィールド値変更）
		Button changeField = new Button("change");
		changeField.setBounds(245, 635, 70, 30);
		add(changeField);

		changeField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object newObj = toObj(newField.getText());
				int selectedIndex = instanceList.getSelectedIndex();// 選択されたインスタンスのIndex取得
				Object selectedInst = allInstance.get(selectedIndex);// 選択されたインスタンスオブジェクト取得
				try {
					allField[fieldList.getSelectedIndex()].set(selectedInst, newObj);
				} catch (IllegalArgumentException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
			}
		});

		// ラベル
		Label labelMethod = new Label("Method list");
		labelMethod.setBounds(330, 510, 180, 20);
		add(labelMethod);
		// メソッドリスト
		List methodList = new List();
		methodList.setBounds(330, 530, 300, 100);
		add(methodList);

		// getボタン（method情報取得）
		Button getM = new Button("get");
		getM.setBounds(565, 500, 70, 30);
		add(getM);
		getM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fieldList.removeAll();
				int selectedIndex = instanceList.getSelectedIndex();// 選択されたインスタンスのIndex取得
				Object selectedInst = allInstance.get(selectedIndex);// 選択されたインスタンスオブジェクト取得
				Class<?> selectedInstType = selectedInst.getClass();// 選択されたインスタンスのクラスオブジェクト取得

				allMethod = getAllMethod(selectedInstType);
				int i = 0;
				// TODO 全てのメソッドを取得する
				for (Method m : allMethod) {
					i++;
					m.setAccessible(true);//privateへのアクセスを有効にする
					Class<?>[] params = m.getParameterTypes();
					String strParams = "(";
					for(int j = 0; j < params.length; j++){
						strParams = strParams + params[j].getSimpleName();
						if(j < params.length - 1){//引数の間にカンマ入れる
							strParams = strParams + ",";
						}
					}
					strParams = strParams + ")";
					methodList.add("(" + i + ") " + m.getName() + strParams);
				}
			}
		});

		// メソッドパラメータ入力部分
		TextField methodParams = new TextField("method params");
		methodParams.setBounds(330, 635, 230, 30);
		add(methodParams);
		// executeボタン（メソッド実行）
		Button executeMethod = new Button("execute");
		executeMethod.setBounds(560, 635, 80, 30);
		add(executeMethod);
		executeMethod.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedInstIndex = instanceList.getSelectedIndex();// 選択されたインスタンスのIndex取得
				Object selectedInst = allInstance.get(selectedInstIndex);// 選択されたインスタンス取得
				int selectedMethodIndex = methodList.getSelectedIndex();// 選択されたメソッドのIndex取得
				java.lang.reflect.Type[] paramTypes = allMethod[selectedMethodIndex].getGenericParameterTypes();// メソッド引数の型
				Object[] params = new Object[paramTypes.length];// 引数を格納する配列
				params = toParamArr(methodParams.getText());// 入力されたパラメーター文字列をobject配列に変換

				if (paramTypes.length == params.length) {

					// TODO パラメーターの型チェック
					if (params.length == 0) {//引数なしメソッド実行
						try {
							allMethod[methodList.getSelectedIndex()].invoke(selectedInst);
						} catch (IllegalAccessException e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						} catch (InvocationTargetException e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						}
					} else {//引数ありメソッド実行
						try {
							allMethod[methodList.getSelectedIndex()].invoke(selectedInst, params);
						} catch (IllegalAccessException e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						} catch (InvocationTargetException e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						}
					}

				} else {
					// 入力パラメータが不正
					// TODO
				}
			}
		});

	}

	public Object[] toParamArr(String strParams) {// カンマで区切られた文字列を対応する型オブジェクトの配列にするメソッド
		String[] strParamsArray = toStrArray(strParams);
		Object[] objParamsArray = toObjArray(strParamsArray);
		return objParamsArray;
	}

	public String[] toStrArray(String strParams) {// カンマで区切られている文字列をString配列にして返すメソッド
		StringCounter strCounter = new StringCounter();
		int paramsNum = strCounter.countString(strParams, ",") + 1;
		String[] strParamsArray;
		if (strParams.equals("")) {
			strParamsArray = new String[0];
			return strParamsArray;
		} else {
			strParamsArray = new String[paramsNum];
		}
		int beginIndex = 0;
		int endIndex = strParams.indexOf(',');
		for (int i = 0; i < paramsNum; i++) {
			if (endIndex == -1) {// 最後の要素
				strParamsArray[i] = strParams.substring(beginIndex, strParams.length());
				return strParamsArray;
			}
			strParamsArray[i] = strParams.substring(beginIndex, endIndex);
			beginIndex = endIndex + 1;
			endIndex = strParams.indexOf(',', beginIndex);
		}
		return strParamsArray;
	}

	public Object[] toObjArray(String[] strParamsArray) {// String配列を対応する型オブジェクトの配列にするメソッド
		Object[] objParamsArray = new Object[strParamsArray.length];
		for (int i = 0; i < strParamsArray.length; i++) {
			switch (checkParamsType(strParamsArray[i])) {
			case EMPTY:
				break;
			case STRING:
				objParamsArray[i] = strParamsArray[i].substring(1, strParamsArray[i].length() - 1);// ""を取り除く
				break;
			case CHAR:
				objParamsArray[i] = strParamsArray[i].charAt(1);// ''を取り除く
				// TODO 複数文字入力されたときどうするか
				break;
			case DOUBLE:
				objParamsArray[i] = Double.parseDouble(strParamsArray[i]);
				// TODO 値チェックを追加する
				break;
			case INT:
				objParamsArray[i] = Integer.parseInt(strParamsArray[i]);
				// TODO 値チェックを追加する
				break;
			case BOOLEAN:
				objParamsArray[i] = Boolean.valueOf(strParamsArray[i]);
				break;
			case INSTANCE:
				objParamsArray[i] = allInstance
						.get(Integer.parseInt(strParamsArray[i].substring(1, strParamsArray[i].length())));
				break;
			default:
				break;
			}
		}
		return objParamsArray;
	}

	public Object toObj(String strParams) {// Stringを対応する型オブジェクトにするメソッド
		Object objParams = new Object();
		switch (checkParamsType(strParams)) {
		case EMPTY:
			break;
		case STRING:
			objParams = strParams.substring(1, strParams.length() - 1);// ""を取り除く
			break;
		case CHAR:
			objParams = strParams.charAt(1);// ''を取り除く
			// TODO 複数文字入力されたときどうするか
			break;
		case DOUBLE:
			objParams = Double.parseDouble(strParams);
			// TODO 値チェックを追加する
			break;
		case INT:
			objParams = Integer.parseInt(strParams);
			// TODO 値チェックを追加する
			break;
		case BOOLEAN:
			objParams = Boolean.valueOf(strParams);
			break;
		case INSTANCE:
			objParams = allInstance.get(Integer.parseInt(strParams.substring(1, strParams.length())));// #を取り除く
			break;
		default:
			break;
		}
		return objParams;
	}

	public ParamsType checkParamsType(String params) {
		if (params.equals("")) {
			return ParamsType.EMPTY;
		} else if (params.charAt(0) == '"' && params.charAt(params.length() - 1) == '"') {
			return ParamsType.STRING;
		} else if (params.charAt(0) == '\'' && params.charAt(params.length()) - 1 == '\'') {
			return ParamsType.CHAR;
		} else if (params.indexOf('.') > -1 && params.indexOf('.', params.indexOf('.')) == -1) {// ひとつだけ"."を含んでいる
			return ParamsType.DOUBLE;
		} else if (params.equals("true") || params.equals("false")) {
			return ParamsType.BOOLEAN;
		} else if (params.charAt(0) == '#') {
			return ParamsType.INSTANCE;
		} else {
			return ParamsType.INT;
		}
	}

	public Method[] getAllMethod(Class<?> c) {//かぶりなく全てのメソッドを取得するメソッド
		java.util.List<Method> allMethod = new ArrayList<Method>();
		Class<?> newClass = c;
		boolean isSameMethod = false;

		while (newClass != Object.class) {//Objectクラスで宣言しているメソッドは見ない
			for (Method m : newClass.getDeclaredMethods()) {//このクラスで宣言している全てのメソッドを取得
				for (Method listm : allMethod) {
					if(isSameMethod(m, listm)){//allMethodに格納されているメソッドと比較
						isSameMethod = true;
					}
				}
				if(!isSameMethod){//allMethodに格納されていなければaddする
					allMethod.add(m);
				}
				isSameMethod = false;
			}
			newClass = newClass.getSuperclass();//親クラスを取得
		}
		return allMethod.toArray(new Method[allMethod.size()]);
	}

	public boolean isSameParamsNum(Method m1, Method m2) {
		return (m1.getParameterCount() == m2.getParameterCount());
	}

	public boolean isSameName(Method m1, Method m2) {
		return (m1.getName() == m2.getName());
	}

	public boolean isSameMethod(Method method, Method listElement) {
		Class<?>[] m1 = method.getParameterTypes();
		Class<?>[] m2 = listElement.getParameterTypes();
		return (isSameName(method, listElement) && isSameParamsNum(method, listElement) && Arrays.equals(m1, m2));
	}

}