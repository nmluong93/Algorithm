package main.java;

import java.util.HashMap;
import java.util.Map;


/**
 * <pre>
 * LeetCode Problem 560, "Subarray Sum Equals K", asks to find the total number of contiguous,
 * non-empty subarrays within an integer array nums whose elements sum exactly to a target value k.
 * The solution requires efficiently counting these subarrays, ideally in \(O(n)\) time using a hash map to track prefix sums
 *   Example 1: nums = [1,1,1], k = 2  -> Output: 2 (Subarrays: [1,1] at index 0-1, and [1,1] at index 1-2).
 *   Example 2: nums = [1,2,3], k = 3  -> Output: 2 (Subarrays: [1,2] and [3]).
 *
 *   </pre>
 */
public class NewClass {


    public static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum = sum + num;

            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
                    /*
                    Hành trình 10 bước
                nums = [2, 1, -1, 3, -2, 1, 2, -2, 1, 2], k = 3.
                Mỗi nums[i] là một bước (dương = lên dốc, âm = xuống dốc). Đây là toàn bộ hành trình:
                sau bước:   (xp)   0    1    2    3    4    5    6    7    8    9
                nums:              2    1   -1    3   -2    1    2   -2    1    2
                độ cao:      0     2    3    2    5    3    4    6    4    5    7
                (xp = xuất phát, độ cao 0.) Mục tiêu: đếm số lần ta leo lên đúng 3 mét giữa hai thời điểm bất kỳ trong hành trình.
                Cuốn sổ tay (bảng băm) sẽ ghi: với mỗi độ cao ta đã đứng, đứng bao nhiêu lần.

                Bắt đầu — Sổ tay: {0: 1} (đã ở độ cao 0 một lần — chính là điểm xuất phát). Count = 0.
                Bước 0 (lên 2 → độ cao 2): Đã từng ở 2 − 3 = −1 chưa? Không. Bỏ qua. Ghi vạch cho độ cao 2.
                → Sổ tay: {0:1, 2:1}. Count = 0.
                Bước 1 (lên 1 → độ cao 3): Đã từng ở 3 − 3 = 0 chưa? Có, 1 lần (lúc xuất phát). +1 mảng con. Ghi vạch cho độ cao 3.
                → Sổ tay: {0:1, 2:1, 3:1}. Count = 1.
                Mảng con đó: nums[0..1] = [2, 1], tổng = 3 ✓
                Bước 2 (xuống 1 → độ cao 2 lần hai): Đã từng ở 2 − 3 = −1 chưa? Không. Bỏ qua. Nhưng ta vừa quay lại độ cao 2 — ghi thêm vạch.
                → Sổ tay: {0:1, 2:2, 3:1}. Count = 1.
                Bước 3 (lên 3 → độ cao 5): Đã từng ở 5 − 3 = 2 chưa? Có — hai lần! +2 mảng con. Ghi vạch cho độ cao 5.
                → Sổ tay: {0:1, 2:2, 3:1, 5:1}. Count = 3.
                Hai mảng con đó:

                Từ lần đầu ở độ cao 2 (sau bước 0) → đến đây: nums[1..3] = [1, -1, 3], tổng = 3 ✓
                Từ lần thứ hai ở độ cao 2 (sau bước 2) → đến đây: nums[3..3] = [3], tổng = 3 ✓

                Cả hai cùng kết thúc tại vị trí hiện tại, cả hai cùng leo lên đúng 3 mét — chỉ khác điểm xuất phát.
                Bước 4 (xuống 2 → độ cao 3 lần hai): Đã từng ở 3 − 3 = 0 chưa? Có, 1 lần. +1. Ghi thêm vạch cho độ cao 3.
                → Sổ tay: {0:1, 2:2, 3:2, 5:1}. Count = 4.
                Mảng con: nums[0..4] = [2, 1, -1, 3, -2], tổng = 3 ✓
                Bước 5 (lên 1 → độ cao 4): Đã từng ở 4 − 3 = 1 chưa? Không. Bỏ qua. Ghi vạch cho độ cao 4.
                → Sổ tay: {0:1, 2:2, 3:2, 4:1, 5:1}. Count = 4.
                Bước 6 (lên 2 → độ cao 6): Đã từng ở 6 − 3 = 3 chưa? Có — hai lần. +2 mảng con. Ghi vạch cho độ cao 6.
                → Sổ tay: {0:1, 2:2, 3:2, 4:1, 5:1, 6:1}. Count = 6.
                Hai mảng con:

                Từ sau bước 1 (độ cao 3) → đến đây: nums[2..6] = [-1, 3, -2, 1, 2], tổng = 3 ✓
                Từ sau bước 4 (độ cao 3) → đến đây: nums[5..6] = [1, 2], tổng = 3 ✓

                Bước 7 (xuống 2 → độ cao 4 lần hai): Đã từng ở 4 − 3 = 1 chưa? Không. Bỏ qua. Ghi thêm vạch cho độ cao 4.
                → Sổ tay: {0:1, 2:2, 3:2, 4:2, 5:1, 6:1}. Count = 6.
                Bước 8 (lên 1 → độ cao 5 lần hai): Đã từng ở 5 − 3 = 2 chưa? Có — hai lần. +2 mảng con. Ghi thêm vạch cho độ cao 5.
                → Sổ tay: {0:1, 2:2, 3:2, 4:2, 5:2, 6:1}. Count = 8.
                Hai mảng con:

                Từ sau bước 0 (độ cao 2) → đến đây: nums[1..8] = [1, -1, 3, -2, 1, 2, -2, 1], tổng = 3 ✓
                Từ sau bước 2 (độ cao 2) → đến đây: nums[3..8] = [3, -2, 1, 2, -2, 1], tổng = 3 ✓

                Bước 9 (lên 2 → độ cao 7): Đã từng ở 7 − 3 = 4 chưa? Có — hai lần. +2 mảng con. Ghi vạch cho độ cao 7.
                → Sổ tay: {0:1, 2:2, 3:2, 4:2, 5:2, 6:1, 7:1}. Count = 10.
                Hai mảng con cuối:

                Từ sau bước 5 (độ cao 4) → đến đây: nums[6..9] = [2, -2, 1, 2], tổng = 3 ✓
                Từ sau bước 7 (độ cao 4) → đến đây: nums[8..9] = [1, 2], tổng = 3 ✓


                Tổng kết
                Đếm tổng cộng có 10 mảng con của nums có tổng = 3:
                [2,1] [1,-1,3] [3] [2,1,-1,3,-2] [-1,3,-2,1,2] [1,2]
                [1,-1,3,-2,1,2,-2,1] [3,-2,1,2,-2,1] [2,-2,1,2] [1,2]
                Để ý điểm cốt lõi: ở các bước 3, 6, 8, 9, ta tra cứu được giá trị có 2 vạch trong sổ tay — và mỗi bước này đóng góp 2 mảng con cùng lúc vào count. Tổng cộng có 4 bước cho "+2", 2 bước cho "+1", và 4 bước không match → 4×2 + 2×1 = 10.
                Đây chính là lý do value trong bảng băm phải là số đếm, không phải boolean:

                Nếu dùng Set (chỉ ghi nhớ "có thấy hay chưa"), thì ở bước 3 ta chỉ cộng 1 thay vì 2, ở bước 6 cũng vậy, ở bước 8 cũng vậy, ở bước 9 cũng vậy → kết quả sai, ra 6 thay vì 10.
                Mỗi lần ta đã đứng ở một độ cao trước đây = một điểm xuất phát hợp lệ riêng biệt cho một mảng con kết thúc tại vị trí hiện tại. Số vạch = số điểm xuất phát = số mảng con cộng thêm vào count.

                Đó là toàn bộ logic của bảng băm trong bài này. Đếm độ cao đã thăm, không quan tâm vị trí — vì mỗi lần thăm đều dẫn đến một mảng con khác nhau, mà ta cần đếm hết.Opus 4.7Adaptive
                     */

    static void main() {
//        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 1, 2}, 3));
    }
}
