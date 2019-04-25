# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from leetcode.ds.TreeNode import TreeNode


class Solution:
    def constructMaximumBinaryTree(self, nums: list) -> TreeNode:
        return self.fuck(nums, 0, len(nums))

    def fuck(self, nums: list, start, end) -> TreeNode:

        if start >= end:
            return None

        maxValue = -1
        maxIndex = 0

        for i in range(start, end):
            if nums[i] > maxValue:
                maxValue = nums[i]
                maxIndex = i

        treeNode = TreeNode(maxValue)
        treeNode.left = self.fuck(nums, start, maxIndex)
        treeNode.right = self.fuck(nums, maxIndex + 1, end)
        return treeNode

s = Solution()
l = [3,2,1,6,0,5]
s.constructMaximumBinaryTree(l)