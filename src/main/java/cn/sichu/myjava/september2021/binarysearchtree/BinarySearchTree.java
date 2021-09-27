package cn.sichu.myjava.september2021.binarysearchtree;

/**
 * 二叉搜索树，是指一棵空树或者具有下列性质的二叉树：
 * <ol>
 * <li>若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * <li>若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * <li>任意节点的左，右子树也分别为二叉搜索树；
 * <li>没有键值相等的节点。
 * </ol>
 * 首先，需要一个节点对象的类。这个对象包含数据域和指向节点的两个子节点的引用。
 * <p>
 * 其次，需要一个树对象的类。这个对象包含一个根节点root。
 * <p>
 * 删除节点（delete） 需要分类讨论：
 * <ol>
 * <li>要删除节点有零个孩子，即叶子节点
 * <ul>
 * <li>只需要将parent.left(或者是parent.right)设置为null，然后Java垃圾自动回收机制会自动删除current节点。
 * </ul>
 * <li>要删除节点有一个孩子
 * <ul>
 * <li>只需要将parent.left(或者是parent.right)设置为curren.right(或者是current.left)即可。
 * </ul>
 * <li>要删除节点有两个孩子
 * <ul>
 * <li>这种情况比较复杂，首先我们引入后继节点的概念，如果将一棵二叉树按照中序周游的方式输出，则任一节点的下一个节点就是该节点的后继节点。
 * <ol>
 * <li>后继节点为待删除节点的右子
 * <p>
 * 只需要将curren用successor替换即可，注意处理好current.left和successor.right.
 * <p>
 * 注意：这种情况下，successor一定没有左孩子，一但它有左孩子，哪它必然不是current的后继节点。
 * <li>后继节点为待删除结点的右孩子的左子树
 * <p>
 * 算法的步骤是：
 * <ol>
 * <li>successorParent.left=successor.right
 * <li>successor.left=current.left
 * <li>parent.left=seccessor
 * </ol>
 * </ol>
 * </ul>
 * </ol>
 * 
 * @author sichu
 * @date 2021/09/27
 */
public class BinarySearchTree {
    /**
     * 节点类
     * 
     * @author sichu
     * @date 2021/09/27
     */
    private class Node {
        // 数据域
        int data;
        // 右子树
        Node right;
        // 左子树
        Node left;
    }

    // 树根节点
    private Node root;

    /**
     * 创建树的时候，主要用到了parent，current来记录要插入节点的位置。
     * <p>
     * 用遍历方法，检查是否成功创建二叉搜索树
     * 
     * @param key
     */
    public void insert(int key) {
        Node p = new Node();
        p.data = key;

        if (root == null) {
            root = p;
        } else {
            Node parent = new Node();
            Node current = root;
            while (true) {
                parent = current;
                if (key > current.data) {
                    current = current.right;
                    if (current == null) {
                        parent.right = p;
                        return;
                    }
                } else {
                    current = current.left;
                    if (current == null) {
                        parent.left = p;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 前序遍历，“中左右”
     * 
     * @param root
     */
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历，“左中右”
     * 
     * @param root
     */
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    /**
     * 后序遍历，“左右中”
     * 
     * @param root
     */
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("preOrder traversal: ");
                preOrder(root);
                System.out.println();
                break;
            case 2:
                System.out.print("inOrder traversal: ");
                inOrder(root);
                System.out.println();
                break;
            case 3:
                System.out.print("posOrder traversal: ");
                postOrder(root);
                System.out.println();
                break;
        }
    }

    /**
     * 如果找到该节点，则返回该节点，否则返回Null
     * 
     * @param key
     * @return
     */
    public Node find(int key) {
        Node current = root;
        while (current.data != key) {
            if (key > current.data) {
                current = current.right;
            } else {
                current = current.left;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /**
     * 方便console输出节点的数值域
     * 
     * @param node
     */
    public void show(Node node) {
        if (node != null) {
            System.out.println(node.data);
        } else {
            System.out.println("null");
        }
    }

    /**
     * 寻找要删除节点的中序后继结点
     * 
     * @param delNode
     * @return
     */
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.right;
        // 用来寻找后继结点
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        // 如果后继结点为要删除结点的右子树的左子，需要预先调整一下要删除结点的右子树
        if (successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    /**
     * 删除结点
     * 
     * @param key
     * @return
     */
    public boolean delete(int key) {
        Node current = root;
        Node parent = new Node();
        boolean isRightChild = true;
        while (current.data != key) {
            parent = current;
            if (key > current.data) {
                current = current.right;
                isRightChild = true;
            } else {
                current = current.left;
                isRightChild = false;
            }
            // 没有找到要删除的节点
            if (current == null) {
                return false;
            }
        }
        // 此时current就是要删除的结点,parent为其父结点
        // 要删除结点为叶子结点
        if (current.right == null && current.left == null) {
            if (current == root) {
                // 整棵树清空
                root = null;
            } else {
                if (isRightChild) {
                    parent.right = null;
                } else {
                    parent.left = null;
                }
            }
            return true;
        } else if (current.left == null) {
            // 要删除结点有一个子结点
            if (current == root) {
                root = current.right;
            } else if (isRightChild) {
                parent.right = current.right;
            } else {
                parent.left = current.right;
            }

            return true;
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isRightChild) {
                parent.right = current.left;
            } else {
                parent.left = current.left;
            }
            return true;
        } else {
            // 要删除结点有两个子结点
            // 找到要删除结点的后继结点
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isRightChild) {
                parent.right = successor;
            } else {
                parent.left = successor;
            }
            successor.left = current.left;
            return true;
        }

    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(39);
        tree.insert(24);
        tree.insert(64);
        tree.insert(23);
        tree.insert(30);
        tree.insert(53);
        tree.insert(60);

        tree.traverse(1);
        tree.traverse(2);
        tree.traverse(3);

    }
}
