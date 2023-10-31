package cs1501_p1;
public class BST<T extends Comparable<T>> implements BST_Inter<T>
{
    private BTNode<T> head;
    private int Count;

    public BST()
    {
        head = null;
        Count = 0;
    }

    public int getCount() {return Count;}

    public void put(T key)
    {
        if(head == null)
        {
            head = new BTNode<T>(key);
            Count++;
            return;
        }
        int Compare_Result = 0;
        BTNode<T> Curr = head;
        while(Curr != null)
        {
            Compare_Result = key.compareTo(Curr.getKey());
            if(Compare_Result == 0) return;
            if(Compare_Result < 0)
            {
                if(Curr.getLeft() != null)
                {
                    Curr = Curr.getLeft();
                    continue;
                }
                else
                {
                    Curr.setLeft(new BTNode<T>(key));
                    Count++;
                    return;
                }
            }
            else
            {
                if(Curr.getRight() != null)
                {
                    Curr = Curr.getRight();
                    continue;
                }
                else
                {
                    Curr.setRight(new BTNode<T>(key));
                    Count++;
                    return;
                }
            }
        }
    }

    private BTNode<T> findNode(T key)
    {
        int Compare_Result = 0;
        BTNode<T> Curr = head;
        while(Curr != null)
        {
            Compare_Result = key.compareTo(Curr.getKey());
            if(Compare_Result == 0) return Curr;
            if(Compare_Result < 0) Curr = Curr.getLeft();
            else Curr = Curr.getRight();
        }
        return null;
    }

    private BTNode<T> findMaxNode(BTNode<T> Curr)
    {
        if(Curr.getRight() == null) return Curr;
        return findMaxNode(Curr.getRight());
    }

    private BTNode<T> findMinNode(BTNode<T> Curr)
    {
        if(Curr.getLeft() == null) return Curr;
        return findMinNode(Curr.getLeft());
    }

    private void deleteRight(BTNode<T> ParentNode)
    {
        BTNode<T> Curr = ParentNode.getRight();
        if(Curr == null) return;
        BTNode<T> LeftSubTree = Curr.getLeft();
        BTNode<T> RightSubTree = Curr.getRight();
        if(LeftSubTree == null)
        {
            ParentNode.setRight(RightSubTree);
            return;
        }
        if(RightSubTree == null)
        {
            ParentNode.setRight(LeftSubTree);
            return;
        }
        ParentNode.setRight(RightSubTree);
        findMinNode(RightSubTree).setLeft(LeftSubTree);
    }

    private void deleteLeft(BTNode<T> ParentNode)
    {
        BTNode<T> Curr = ParentNode.getLeft();
        if(Curr == null) return;
        BTNode<T> LeftSubTree = Curr.getLeft();
        BTNode<T> RightSubTree = Curr.getRight();
        if(LeftSubTree == null)
        {
            ParentNode.setLeft(RightSubTree);
            return;
        }
        if(RightSubTree == null)
        {
            ParentNode.setLeft(LeftSubTree);
            return;
        }
        ParentNode.setLeft(LeftSubTree);
        findMaxNode(LeftSubTree).setRight(RightSubTree);
    }

    private int findMaxHeight(BTNode<T> Curr)
    {
        if(Curr == null) return 0;
        int LeftSubTreeMaxHeight = findMaxHeight(Curr.getLeft());
        int RightSubTreeMaxHeight = findMaxHeight(Curr.getRight());
        int SubTreeMaxHeight = LeftSubTreeMaxHeight > RightSubTreeMaxHeight ? LeftSubTreeMaxHeight : RightSubTreeMaxHeight;
        return (1 + SubTreeMaxHeight);
    }

    private int findMinHeight(BTNode<T> Curr)
    {
        if(Curr == null) return 0;
        int LeftSubTreeMinHeight = findMinHeight(Curr.getLeft());
        int RightSubTreeMinHeight = findMinHeight(Curr.getRight());
        int SubTreeMinHeight = LeftSubTreeMinHeight < RightSubTreeMinHeight ? LeftSubTreeMinHeight : RightSubTreeMinHeight;
        return (1 + SubTreeMinHeight);
    }

    private String inOrderTraversalHelper(BTNode<T> Curr)
    {
        String outPut = "" + Curr.getKey();
        if(Curr.getLeft() != null) outPut = inOrderTraversalHelper(Curr.getLeft()) + ":" + outPut;
        if(Curr.getRight() != null) outPut = outPut + ":" + inOrderTraversalHelper(Curr.getRight());
        return outPut;
    }

    private String serializeHelper(BTNode<T> Curr)
    {
        if(Curr == null) return "X(NULL)";
        String outPut = "" + Curr.getKey();
        BTNode<T> LeftSubTree = Curr.getLeft();
        BTNode<T> RightSubTree = Curr.getRight();
        if(LeftSubTree == null && RightSubTree == null) return ("L(" + outPut + ")");
        else
        {
            outPut = "I(" + outPut + ")";
            outPut = outPut + "," + serializeHelper(Curr.getLeft());
            outPut = outPut + "," + serializeHelper(Curr.getRight());
        }
        return outPut;
    }

    private BTNode<T> reverseHelper(BTNode<T> Curr)
    {
        if(Curr == null) return null;
        BTNode<T> outPut = new BTNode<T>(Curr.getKey());
        outPut.setLeft(reverseHelper(Curr.getRight()));
        outPut.setRight(reverseHelper(Curr.getLeft()));
        return outPut;
    }

    public boolean contains(T key) {return (findNode(key) != null);}

    public void delete(T key)
    {
        if(head == null) return;
        else if(head.getKey().compareTo(key) == 0)
        {
            BTNode<T> headLeft = head.getLeft();
            BTNode<T> headRight = head.getRight();
            if(headLeft == null)
            {
                head = headRight;
                Count--;
                return;
            }
            if(headRight == null)
            {
                head = headLeft;
                Count--;
                return;
            }
            head = headRight;
            findMinNode(headRight).setLeft(headLeft);
            Count--;
            return;
        }
        int Compare_Result = 0;
        BTNode<T> Curr = head;
        while(Curr != null)
        {
            Compare_Result = key.compareTo(Curr.getKey());
            if(Compare_Result < 0)
            {
                BTNode<T> LeftSubTree = Curr.getLeft();
                if(LeftSubTree == null) return;
                if(key.compareTo(LeftSubTree.getKey()) == 0)
                {
                    deleteLeft(Curr);
                    Count--;
                    return;
                }
                Curr = Curr.getLeft();
                continue;
            }
            else
            {
                BTNode<T> RightSubTree = Curr.getRight();
                if(RightSubTree == null) return;
                if(key.compareTo(RightSubTree.getKey()) == 0)
                {
                    deleteRight(Curr);
                    Count--;
                    return;
                }
                Curr = Curr.getRight();
                continue;
            }
        }
    }

    public int height() {return findMaxHeight(head);}

    public boolean isBalanced() {return ((findMaxHeight(head) - findMinHeight(head)) <= 1);}

    public String inOrderTraversal()
    {
        if(head == null) return "";
        return inOrderTraversalHelper(head);
    }

    public String serialize()
    {
        if(head == null) return "";
        String outPut = "R(" + head.getKey() + ")";
        outPut = outPut + "," + serializeHelper(head.getLeft());
        outPut = outPut + "," + serializeHelper(head.getRight());
        return outPut;
    }

    public BST<T> reverse()
    {
        BST<T> newTree = new BST<T>();
        newTree.Count = this.getCount();
        newTree.head = reverseHelper(this.head);
        return newTree;
    }
}